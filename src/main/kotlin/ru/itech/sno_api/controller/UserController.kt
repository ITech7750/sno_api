package ru.itech.sno_api.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import ru.itech.sno_api.dto.UserDTO
import ru.itech.sno_api.service.UserService

@RestController
@RequestMapping("/api/v1/users")
@Tag(
    name = "User API",
    description = "Пользователи"
)
class UserController(
    private val userService: UserService
) {

    @Operation(method = "Получение всех пользователей")
    @GetMapping
    fun getAll(): List<UserDTO> =
        userService.getAll()

    @GetMapping("/paginated")
    fun getAllP(@RequestParam("page") pageIndex: Int) : List<UserDTO> =
        userService.getAllP(pageIndex)


    @Operation(method = "Получение пользователя по идентификатору")
    @GetMapping("/{userId}")
    fun getById(@PathVariable userId: Long): UserDTO =
        userService.getById(userId)

    @Operation(method = "Создание нового пользователя")
    @PostMapping
    fun create(@RequestBody user: UserDTO): UserDTO =
        userService.create(user)

    @Operation(method = "Обновление данных пользователя")
    @PutMapping("/{userId}")
    fun update(@PathVariable userId: Long, @RequestBody user: UserDTO): UserDTO =
        userService.update(userId, user)

    @Operation(method = "Удаление пользователя")
    @DeleteMapping("/{userId}")
    fun delete(@PathVariable userId: Long) =
        userService.delete(userId)
}
