package com.circleci

import java.io.File
import java.io.FileNotFoundException

fun rerun(): Unit {
    val file = File(System.getProperty("user.home"),  "pass.txt")
    if (file.exists()) {
        println("Aha, all good! File ${file.absolutePath} already exists.")
    } else {
        file.writer().use { it.write(1) }
        throw FileNotFoundException("File ${file.absolutePath} was not generated yet")
    }
}

fun main(args: Array<String>) {
    val method = args.firstOrNull()
    when (method) {
        "rerun" -> rerun()
        else -> println("Method not found. But that is okay!")
    }
}