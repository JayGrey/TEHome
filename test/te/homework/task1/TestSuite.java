package te.homework.task1;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PercussionFactoryTest.class,
        WindFactoryTest.class,
        StringedFactoryTest.class,
        InstrumentTest.class}
)
public class TestSuite {
}