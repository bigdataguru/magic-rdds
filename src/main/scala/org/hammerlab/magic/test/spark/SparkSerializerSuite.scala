package org.hammerlab.magic.test.spark

import java.nio.ByteBuffer

import com.holdenkarau.spark.testing.SharedSparkContext
import org.apache.spark.SparkEnv

trait SparkSerializerSuite {
  self: SharedSparkContext =>

  private def serializer = SparkEnv.get.serializer.newInstance()

  def serialize(item: Any): ByteBuffer = serializer.serialize(item)
  def deserialize[T](bytes: ByteBuffer): T = serializer.deserialize(bytes)
  def deserialize[T](bytes: Array[Byte]): T = deserialize(ByteBuffer.wrap(bytes))
}
