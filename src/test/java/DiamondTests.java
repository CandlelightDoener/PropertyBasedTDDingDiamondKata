import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.hamcrest.Matcher;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


@RunWith(JUnitQuickcheck.class)
public class DiamondTests {

    @Property
    public void hightIsWidth(@InRange(minChar = 'a', maxChar = 'z') Character input) {
        Diamond diamond = new Diamond(input);
        assertThat(diamond.width(), is(diamond.height()));
    }

    @Property
    public void hightIsTwoTimesNoOfCharactersMinusOne(@InRange(minChar = 'a', maxChar = 'b') Character input) {
        Diamond diamond = new Diamond(input);
        int expectedHeight = 2 * (input - 'a') - 1;
        assertThat(diamond.height(), is(expectedHeight));
    }

    private class Diamond {
        private Character input;

        public Diamond(Character input) {
            this.input = input;
        }

        public int width() {
            return -1;
        }

        public int height() {
            return -1;
        }
    }
}
