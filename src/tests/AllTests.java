package tests;
/**
 * 
 */


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Jonathon Davis
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ PlayerTest.class, PokerHandTest.class, RankSuitAndCardTest.class, OfficialTest.class, GameTest.class })
public class AllTests {

}