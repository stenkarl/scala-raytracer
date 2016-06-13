package raytracer.shape

import raytracer.Ray

import scalafx.scene.paint.Color

/**
  * Created by sten on 6/12/16.
  */
trait Shape {

  def intersect(ray:Ray):Color

}
