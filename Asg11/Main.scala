import scala.io.Source

object main {

  def main(args:Array[String]) : Unit = {

    val filename = "weatherHistory.csv"
    val lines = Source.fromFile(filename).getLines()

    val data = lines.map (line=>{

    val row = line.split(",")
    val temp = row(3).toDouble
    val dP = row(4).toDouble
    val wS = row(6).toDouble

    (temp, dP, wS)
  })

  val(tempSum, dPSum, wSSum, count) = 

  data.foldLeft((0.0,0.0,0.0,0)) {
    case((tempAcc, dPAcc, wSAcc, countAcc),(temp, dP, wS)) => {
      (temp+tempAcc, dP+dPAcc, wS+wSAcc, countAcc+1)
    }
  }

    val avgT = tempSum/count
    val avgD = dPSum/count
    val avgW = wSSum/count

  println(s"Temp :\t $avgT")
  println(s"DP :\t $avgD")
  println(s"WS :\t $avgW")
  }
}