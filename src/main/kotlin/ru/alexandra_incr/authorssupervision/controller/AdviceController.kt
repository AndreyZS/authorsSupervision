package ru.alexandra_incr.authorssupervision.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.alexandra_incr.authorssupervision.exceptions.LockedException
import ru.alexandra_incr.authorssupervision.exceptions.PasswordException
import ru.alexandra_incr.authorssupervision.exceptions.RegistrationException

data class Message(val test:String)

@RestControllerAdvice
class AdviceController {

    @ExceptionHandler(RegistrationException::class)
    fun registrationException(exc:RegistrationException): ResponseEntity<Message> {
       return ResponseEntity(Message(exc.message), HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(PasswordException::class)
    fun passwordException(exc:PasswordException): ResponseEntity<Message> {
        return ResponseEntity(Message(exc.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(LockedException::class)
    fun lockedException(exc:LockedException): ResponseEntity<Message> {
        return ResponseEntity(Message(exc.message), HttpStatus.FORBIDDEN)
    }
}