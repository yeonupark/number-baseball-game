import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckMatchTest {

    @Test
    fun testPerfectMatch() {
        val result = checkMatch("1234", "1234")
        assertEquals("4스트라이크", result)
    }

    @Test
    fun testAllWrong() {
        val result = checkMatch("1234", "5678")
        assertEquals("제로", result)
    }

    @Test
    fun testOnlyBalls() {
        val result = checkMatch("1234", "4321")
        assertEquals("4볼 ", result)
    }

    @Test
    fun testMixMatch() {
        val result = checkMatch("1234", "1243")
        assertEquals("2볼 2스트라이크", result)
    }

}
