package example

import com.whisk.docker.{DockerContainer, DockerReadyChecker}
import org.scalatest.Suite

trait DockerRedisSpecSupport extends DockerSpecSupport { this: Suite =>

  protected val redisPort: Int = 6379

  lazy val redisContainer: DockerContainer =
    DockerContainer("redis:3.2.4-alpine")
      .withPorts(6379 -> Some(redisPort))
      .withReadyChecker(DockerReadyChecker.LogLineContains(
        "The server is now ready to accept connections"))

  override def dockerContainers: List[DockerContainer] =
    redisContainer :: super.dockerContainers

}
