import org.jetbrains.agda.util.lisp.LispParser;
import org.jetbrains.agda.util.lisp.SExpression;
import org.junit.Assert;
import org.junit.Test;

public class TestLispParser {
    @Test
    public void testStrings() throws Exception {
        SExpression expr = new LispParser("(a (b) \"text\")").parseExpression();
        Assert.assertEquals("text", expr.getChildren().get(2).getValue());
    }

    @Test
    public void testStringsWithQuotation() throws Exception {
        SExpression expr = new LispParser("(a (b) \"\\\"text\\\"\")").parseExpression();
        Assert.assertEquals("\"text\"", expr.getChildren().get(2).getValue());
    }
}
