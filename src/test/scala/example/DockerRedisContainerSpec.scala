package example

import akka.testkit.SocketUtil
import org.scalatest.{DiagrammedAssertions, FunSpec, Matchers}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Second, Seconds, Span}

class DockerRedisContainerSpec
    extends FunSpec
    with DockerRedisSpecSupport
    with Matchers
    with ScalaFutures
    with DiagrammedAssertions {

  implicit val pc: PatienceConfig =
    PatienceConfig(Span(20, Seconds), Span(1, Second))

  override protected val redisPort: Int =
    SocketUtil.temporaryServerHostnameAndPort()._2

  describe("redis container") {
    it("should be able to run") {
      isContainerReady(redisContainer).futureValue should be(true)
      redisContainer.getPorts().futureValue.get(6379) should be(Some(redisPort))
    }
  }
}
