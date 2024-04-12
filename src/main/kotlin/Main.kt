import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.openapi.OpenApiInfo
import io.javalin.openapi.plugin.DefinitionConfiguration
import io.javalin.openapi.plugin.OpenApiPlugin
import io.javalin.openapi.plugin.redoc.ReDocPlugin
import io.javalin.openapi.plugin.swagger.SwaggerPlugin

fun main(args: Array<String>) {
    Javalin.create { config ->
        config.registerPlugin(OpenApiPlugin { pluginConfig ->
            pluginConfig.withDefinitionConfiguration { version, definition ->
                definition.withInfo { info: OpenApiInfo ->
                    info.title = "Javalin OpenAPI example"
                }
            }
            pluginConfig.withDocumentationPath("openapi")
        })
        config.registerPlugin(SwaggerPlugin())
        config.registerPlugin(ReDocPlugin())
        config.router.apiBuilder {
            path("users") {
                get(UserController::getAll);
                post(UserController::create);
                path("{userId}") {
                    get(UserController::getOne);
                    patch(UserController::update);
                    delete(UserController::delete);
                }
            }
        }
    }.start(7001)

    println("Check out ReDoc docs at http://localhost:7001/redoc")
    println("Check out Swagger UI docs at http://localhost:7001/swagger")
}