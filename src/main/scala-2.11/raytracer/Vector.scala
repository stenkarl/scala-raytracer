package raytracer

/**
  * Created by sten on 6/12/16.
  */
case class Vector(x:Double, y:Double, z:Double) {

  val magnitude: Double = Math.sqrt(x*x + y*y + z*z)

  def dot(other:Vector): Double = x * other.x + y * other.y + z * other.z

  def times(num:Double) = Vector(x * num, y * num, z * num)

  def minus(other:Point) = Vector(x - other.x, y - other.y, z - other.z)

  def normalize = Vector(x/magnitude, y/magnitude, z/magnitude)

}
