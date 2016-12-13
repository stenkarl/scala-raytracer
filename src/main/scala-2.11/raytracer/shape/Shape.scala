package raytracer.shape

import raytracer.Ray

import scalafx.scene.paint.Color

/**
  * Created by sten on 6/12/16.
  */
trait Shape {

  def intersect(ray:Ray):Color

  def inRange(num:Double, ambient:Double): Double = if (num < ambient) ambient else if (num > 1.0) 1.0 else num

}
