package org.agda.external;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.agda.lisp.LispParser;
import org.agda.lisp.SExpression;
import org.agda.util.FileUtil;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class AgdaProjectComponent implements ProjectComponent {
    private final boolean keepAlive = false;
    private final Project project;
    private AgdaProcess myProcess;

    public AgdaProjectComponent(Project project) {
        this.project = project;
    }

    public AgdaProcess getProcess() {
        return myProcess;
    }

    public void projectOpened() {
    }

    public void projectClosed() {
    }

    @NotNull
    public String getComponentName() {
        return "AgdaProjectComponent";
    }

    public void initComponent() {
        if (keepAlive) {
            try {
                myProcess = new AgdaProcess();
                myProcess.init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void disposeComponent() {
        if (keepAlive) {
            myProcess.stop();
        }
    }

    public synchronized void execute(String cmd, AgdaProcess.Callback callback) throws IOException {
        if (keepAlive) {
            myProcess.execute(cmd, callback);
        } else {
            AgdaProcess process = new AgdaProcess();
            process.init();
            process.execute(cmd, callback);
            process.stop();

        }
    }

    public static void parseExpression(SExpression expression, List<AgdaExternalAnnotation> messages) {
        String errorMessage = null;

        if ("*Error*".equals(expression.get(1).getValue())) {
            errorMessage = expression.get(2).getValue();
            messages.add(new AgdaCompilerMessage(errorMessage));
        }
        if ("*All Goals*".equals(expression.getValue(1))) {
            messages.addAll(getGoals(expression.getValue(2)));
        }
    }

    private static List<AgdaExternalAnnotation> getGoals(String data) {
        List<AgdaExternalAnnotation> annotations = new ArrayList<AgdaExternalAnnotation>();
        int index = 0;
        for (String str : data.split("\\\\n")) {
            int i = str.indexOf(": ");
            if (i > 0) {
                str = str.substring(i + 2);
                annotations.add(new GoalAnnotation(index, str));
            }
            index++;
        }
        return annotations;
    }

    private static String esc(String path) {
        return path.replace("\\", "\\\\");
    }

    public List<AgdaExternalAnnotation> load(String path) {
        try {
            File agdaFile = new File(path);

            String cmd = "IOTCM \"" + esc(agdaFile.getPath()) + "\" NonInteractive Indirect ( Cmd_load \"" + esc(agdaFile.getPath()) + "\" [\".\"] )\n";
            System.out.println(cmd);

            final List<AgdaExternalAnnotation> messages = new ArrayList<AgdaExternalAnnotation>();
            execute(cmd, new AgdaProcess.Callback() {

                @Override
                public boolean call(String command) {
                    SExpression cmdExpression = new LispParser(command).parseExpression();
                    if (cmdExpression.get(1) != null) {
                        parseExpression(cmdExpression, messages);
                    }
                    if (command.contains("agda2-highlight-load-and-delete-action")) {
                        SExpression expr = new LispParser(command).parseExpression();
                        try {
                            File file = new File(expr.getValue(1));
                            String data = FileUtil.readFile(file);
                            file.delete();
                            SExpression expression = new LispParser(data).parseExpression();
                            messages.addAll(AgdaSyntaxAnnotation.parse(expression));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!command.contains("*Type-checking*") && !command.contains("agda2-highlight-add-annotations")) {
                        System.out.println("[" + command + "]");
                    }
                    return true;
                }
            });

            return messages;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}