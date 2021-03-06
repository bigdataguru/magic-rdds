package org.hammerlab.magic.kryo

import com.esotericsoftware.kryo.Kryo
import org.apache.spark.serializer.KryoRegistrator
import org.hammerlab.magic.rdd.RunLengthRDD
import org.hammerlab.magic.rdd.grid.PartialSumGridRDD
import org.hammerlab.magic.rdd.keyed.KeySamples
import org.hammerlab.magic.rdd.partitions.RDDStats
import org.hammerlab.magic.rdd.sliding.SlidingRDD

class Registrar extends KryoRegistrator {
  override def registerClasses(kryo: Kryo): Unit = {
    KeySamples.register(kryo)
    PartialSumGridRDD.register(kryo)
    RunLengthRDD.register(kryo)
    RDDStats.register(kryo)
    SlidingRDD.register(kryo)
  }
}
