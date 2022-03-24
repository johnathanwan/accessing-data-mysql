package com.example.accessingdatamysql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/demo")
class MainController {

    @Autowired
    val userRepository: UserRepository? = null

    @PostMapping("/add")
    @ResponseBody
    fun addNewUser(@RequestParam name: String, @RequestParam email: String): String {
        val user = User()
        user.name = name
        user.email = email
        userRepository!!.save(user)
        return "Saved"
    }

    @GetMapping("/all")
    @ResponseBody
    fun getAllUsers(): Iterable<User> = userRepository!!.findAll()
}