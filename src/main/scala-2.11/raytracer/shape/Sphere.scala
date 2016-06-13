package raytracer.shape

import raytracer.{Point, Ray}

import scalafx.scene.paint.Color

/**
  * Created by sten on 6/12/16.
  */
case class Sphere(center:Point, radius:Double) extends Shape {

  def intersect(ray:Ray):Color = {
    def originCenterDiff = ray.origin.minus(center)

    def b = ray.direction.dot(originCenterDiff.times(2))
    def c = originCenterDiff.dot(originCenterDiff) - radius * radius

    def discriminant = b * b - 4 * c;

    if (discriminant < 0) {
      return null
    }

    Color.DarkSlateBlue
  }

}
