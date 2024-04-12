import io.javalin.http.Context
import io.javalin.openapi.HttpMethod
import io.javalin.openapi.OpenApi
import io.javalin.openapi.OpenApiContent
import io.javalin.openapi.OpenApiResponse
import org.eclipse.jetty.server.Authentication

object UserController {

    fun create(ctx: Context) {
    }

    @OpenApi(
        summary = "Get all users",
        operationId = "getAllUsers",
        tags = ["User"],
        responses = [OpenApiResponse("200", [OpenApiContent(Array<Authentication.User>::class)])],
        path = "/users",
        methods = [HttpMethod.GET]
    )
    fun getAll(ctx: Context) {
    }

    fun getOne(ctx: Context) {
    }

    fun update(ctx: Context) {
    }

    fun delete(ctx: Context) {
    }

}