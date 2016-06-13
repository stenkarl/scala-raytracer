package raytracer

/**
  * Created by sten on 6/12/16.
  */
case class Vector(x:Double, y:Double, z:Double) {

  def dot(other:Vector) = x * other.x + y * other.y + z * other.z

  def times(num:Double) = Vector(x * num, y * num, z * num)

}
