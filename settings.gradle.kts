include("cats4")
include("cats4:api-gateway")
findProject(":cats4:api-gateway")?.name = "api-gateway"
include("cats4:cats")
findProject(":cats4:cats")?.name = "cats"
include("cats4:owners")
findProject(":cats4:owners")?.name = "owners"
include("cats4:global-libs")
findProject(":cats4:global-libs")?.name = "global-libs"
include("cats4:api-gateway:api-gateway-app")
findProject(":cats4:api-gateway:api-gateway-app")?.name = "api-gateway-app"
include("cats4:api-gateway:security")
findProject(":cats4:api-gateway:security")?.name = "security"
include("cats4:cats:cats-app")
findProject(":cats4:cats:cats-app")?.name = "cats-app"
include("cats4:cats:cats-models")
findProject(":cats4:cats:cats-models")?.name = "cats-models"
include("cats4:cats:cats-client")
findProject(":cats4:cats:cats-client")?.name = "cats-client"
include("cats4:owners:owners-app")
findProject(":cats4:owners:owners-app")?.name = "owners-app"
include("cats4:owners:owners-client")
findProject(":cats4:owners:owners-client")?.name = "owners-client"
include("cats4:owners:owners-models")
findProject(":cats4:owners:owners-models")?.name = "owners-models"
include("cats4:global-libs")
findProject(":cats4:global-libs")?.name = "global-libs"
