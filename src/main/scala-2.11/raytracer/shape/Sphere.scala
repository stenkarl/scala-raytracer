package raytracer.shape

import raytracer.{Point, Ray, Vector}

import scalafx.scene.paint.Color

/**
  * Created by sten on 6/12/16.
  */
case class Sphere(center:Point, radius:Double, color:Color) extends Shape {

  val lightDir = Vector(0, -0.4, -0.4)

  def intersect(ray:Ray):Color = {
    def originCenterDiff = ray.origin.minus(center)

    def b = ray.direction.dot(originCenterDiff.times(2))
    def c = originCenterDiff.dot(originCenterDiff) - radius * radius

    def discriminant = b * b - 4 * c

    if (discriminant < 0) {
      return null
    }

    def sqrtDisc = Math.sqrt(discriminant)
    def distance = if (discriminant == 0) -b else Math.min(-b + sqrtDisc, -b - sqrtDisc)

    val hit = ray.origin.plus(ray.direction.times(distance))

    val normal = hit.minus(center).normalize

    val intensity = lightDir.dot(normal)

    Color.color(inRange(color.getRed + intensity, color.getRed),
      inRange(color.getGreen + intensity, color.getGreen), inRange(color.getBlue + intensity, color.getBlue))
  }

}
