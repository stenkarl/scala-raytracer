package raytracer

/**
  * Created by sten on 6/12/16.
  */
case class Point(x:Double, y:Double, z:Double) {

  def minus(other:Point) = Vector(x - other.x, y - other.y, z - other.z)

  def plus(other:Vector) = Vector(x + other.x, y + other.y, z + other.z)


}
