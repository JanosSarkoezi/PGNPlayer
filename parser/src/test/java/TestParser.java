import de.sjsoft.pgn.DemoListener;
import de.sjsoft.pgn.parser.PGNLexer;
import de.sjsoft.pgn.parser.PGNParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * @author saj
 */
public class TestParser {
    @Test
    @Ignore
    public void test() throws IOException {
        PGNLexer lexer = new PGNLexer(new ANTLRFileStream("./src/test/resources/Karpov.pgn"));
        PGNParser parser = new PGNParser(new CommonTokenStream(lexer));

        // Use the demo listener which will print some info about the PGN file.
        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTree tree = parser.parse();

        walker.walk(new DemoListener(), tree);
    }

    @Test
    public void testHello() {
        System.out.println("---------------- Hello -------------");
    }

    @Test
    public void testHello2() {
        System.out.println("---------------- Hello -------------");
    }
    @Test
    public void testFailed() {
        Assert.assertTrue(true);
    }

}
