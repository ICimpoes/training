package puzzle.finalContest

object FinalApp extends App {
  var lines = List[Int]()

  val s = "100010111101111110101111011011100011101111110011111101000100010100011111100001101001110001111010011100111110111111001111110000111011001011100100010100011111100001100101111000111101111110100110001111010011100111010001001010011110001111011111101101111001110001111101001100110010001011011101110001111000111011011101011111000011010010101001010001011001001100111110101011000111111000110101111100011110111111010001100000100010101100111010101100111111010011001111111000110011111101000100010111001011100011110101111010111010111100100110111011001110100010110111011100011110001110110101000101100011111011001000101110110110101011001110100010111100111010111100110110011111101000100010110010111100011110000111011011001111111010111011001011100100010111011111100001100110110011111101001110101111011011000111110000110011001000101100101111011111101011110110111000111011111100111111010001000101100011111000011001100100010110001111001011100101111000111101111110000111011001000101110010111010011001111110101111010111101111110100110011111101010110000010001010001011110001111000011101101101011111000011101111100111010001011000111110000110011001000101100110110011111110001100111110111011100011110010010001011010001110111111010011101101101010110011111101000100010010101011001110110000110100101100000100010111100011010111100011010001011001011110001110111111100101100111111011011001111110000110010111110110100010110111111000111110110111010011010111111010010101101011100100010110011111110101100011110111111100101101110110011111101010101110010001011001011100011111010111001110100010111010111101101110111110011011010111100111111010101011100100010110101111100001101000111000111101001101111110001111011100100010110010111000111110110110010111010100100010111011111100101110101010001011110011101011111011011010100100010111101111100011110111111010001000101101101110011111110110100010111011011001111100011110111101000101101111110011111011111100100110011111101001110101011000001000101000110110101111101011100101110101111100101101110110101111100001100111111010101000101100011111000011001100100010101001011101001100011110010111101101101011110010111001111110101010111001000101000011110010111101101101011111100011001111101110111101101000101100101111000111100001110110111010011010111100100111011111101101100111010001011101101110001010001011000111101110110111001000101000110110101111101011100101110101111100101101110110101111100001100111111010101000101100011111000011001100100010101001011101001100011110010111101101101011110010111001111110101011000001000101010101111011111100101110010111000111101001110110010001011101101101010110011101000101100110110011111110001100111110111011100011110010110111111001111110000111011001000101110001110100001000101100101111000111010101100111111010111010111111000110011101000101100101111000111011111110010110001111100001111011111100111010111100110110011101000101110110110011111001011101010111000011010111110011111011111001111110101010111001000101101111110011111101101101010111000111001101110101010001011000111110000110011001000101110010110011111100011110010110111011001110100010111001011101001110001110010111001111110101111010111001111110101011000001000101001011111000011100001110001111100011000111110110110101111100011110000010111001000101010010111010011100011101111111000111101101100111010001011000111110000110011001000101110100110011111001011110001110100111100001101011111110011001110100010110101111100001110000111000111110001100011111011011010111110001111000001100000100010100101111001101100111111000011101101101011110100011110110101110010001011010111101111111001011011101100111110111111001111110000111011001000101100011111000011001100100010111010111010101100011111010011001110100010110001111101100100010110111011001111100011111010111101100100010111000111100001100111010001011010111110000111000011100011111000110001111101101101011111000111100000100010010101011000111100101111011011101111100011110111001000101001011110111111100101110100111000111110001100111110111111001111110000111011011101010100010110101111100001110110111010011100011100110111011111001011100111110011001000101100011111000011001100100010111010111010101100011111010011001111100110010001011110001101011110001101000101110110110101011001110100010100011011010111110101110010111010111110010110111011010111110000110011111101010100010111000111101000100010110001111001011110100111000111101011110101010001011000111100101110010111100011110111111000011101101110101010101101100000100010101010011001111101111110011111011111100100110011111101000100010110101111100001110000111000111110001100011111011011010111110001111000001000101101011111010101000101110001111000011011101111011010001011110001100011110111011101111100011110010011011101100111010001011100011110000110010111001110100010110101111101100100010110101111101010100010111010111010101100011111010011001111100110011000001000101001111100011010001100100010110101111101010100010110100111100011110001110011001000101100011111011001000101101011111000011100001110001111100011000111110110110101111100011110000010001011000111110000110011001000101110110110101011010111110101010001011010111110101010001011000110100010100010010010111001001010001011000111110100110011111000110100010110100011100011110100010001011101111110101010001011000111110101010001011000110100010110010111100011101111111001011000111110000111101101000101100011111010101000101111001110011101000101101001111010011100011111001011000001000101010110100011110000111001111010111001000101000011110011011100011110010111011001000101010110100011110000111001111010001011000111110101010001011101101101010110011101000101101111110011111101101101010111000111001100100010111000111010000100010110010111010101110001110101111001011100111010001011010001110001111010001000101100011110111011011100100010111001011101001110001110110011001111100101111011001000101100011110010111101101101011111100011010111110110110101111001111110101011000001000101000101111000111100001110110111010011010111100100111011111101101100111010001011101101110001010001010101101000111100001110011110100010110011011001111111000110011111011101110001111001011011111100111111000011101100100010110001111100001100110010001011100101110100111000111011111110001111011011001110100010101011010001111000011100111101000101100011110011011100011110010111011011010111110001111000001000101111001110101111101101101010110101111100000100010111101111100011110111111010001000101000110101011101000101100011111000011001100100010110010111100011101111111001011000111110000111101111110011101011110011011001110110000010001010011111110001111000011010111110110111000111101000100010110010111100011101111111001011011101101011110001111100001100101110011101100000100010100010111100011101111111001011101001100111110101011001111110000111010111010111111000110011101000101100101111000111110001100111111010011000111101001110011101000101110101110101011100011110111110111011001100100010110001111011101110101111000101000101101011111000011001011101110111011111001101100111010001010000111001111011000001000101010110110101011010111110000110110101000101000100100101110010010101110010001010000111110101010001011110111110001111011101000101101001110011111101100100010110101111100001111000111000111011101111000110011111001100100010110101111100000100010111000011001111111001010001011010111110000110101111101101101011110001111101101101011111100011001111110101010111001000101100100111011111101011101011111000011001111110101111010101000101110010111010011100011100101110011111101011110101010001011101001100111010111111001111110000110100111010111110000110011111001111110100110101111100001101001010111001000101110001111010001000101101100111011111101011110110010001011010011100111111000011001111110100110001111011100100010100010010000111010111010001011010111101111111001011101001110001111100011001111101111110011111100001110110011000001000101000101110001111100000100010111011011010101100111010001011100101110100111000111001011100111111010111101010100010111000111101000100010111001011101001100011110010111101101101011110010111001110100010110010011001110100010110101111011111110010111010011100011111000110011111001100100010111011011100010100010111010111001011100011110111011001111000001"
  println(s.length)

  s.sliding(7, 7).map{c => (Integer.parseInt(c, 2) - 2).toChar}.foreach(print)

}
