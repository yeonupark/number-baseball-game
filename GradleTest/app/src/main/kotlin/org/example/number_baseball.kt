fun main() {
  val target = generateRandomTarget()

  while (true) {
    val guess = getValidGuess()
    if (guess == target) {
      println("정답!")
      break
    } 
    println(checkMatch(target, guess))
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

fun checkMatch(target: String, guess: String): String {
  val targetSet = target.toSet()

  var ball = 0
  var strike = 0

  for (i in 0 until 4) {
    if (guess[i] == target[i]) {
      strike ++
    } else if (guess[i] in targetSet) {
        ball ++
    }
  }
  
  return formatResult(ball, strike)
}

fun formatResult(ball: Int, strike: Int) : String {
  var result = ""

  if (ball == 0 && strike == 0) {
    result = "제로"
  } else {
    if (ball != 0) {
      result += "${ball}볼 "
    }
    if (strike != 0) {
      result += "${strike}스트라이크"
    }
  }

  return result
}