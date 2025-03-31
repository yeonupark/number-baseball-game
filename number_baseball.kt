fun main() {
  val target = generateRandomTarget()
  var guess = getValidGuess()
  while (target != guess) {
    guess = getValidGuess()
  }
}

fun generateRandomTarget(): String {
  return (0..9).shuffled().take(4).joinToString("")
}

fun getValidGuess(): String {
  print("숫자를 입력해주세요: ")
  val target = readLine()

  target?.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다. 애플리케이션이 종료됩니다.")

  if (target.length != 4) {
    throw IllegalArgumentException("네 자리 수가 아닙니다. 애플리케이션이 종료됩니다.")
    // issue: jar 파일 삭제 안됨
  } 

  return target
}
