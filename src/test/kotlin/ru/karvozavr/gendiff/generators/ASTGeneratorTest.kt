package ru.karvozavr.gendiff.generators

import org.junit.Test

import org.junit.Before
import java.nio.file.Paths

class ASTGeneratorTest {

    private lateinit var generator: ASTGenerator

    @Before
    fun init() {
        generator = ASTGenerator()
    }

    @Test
    fun testGenerate() {
        val file = Paths.get(javaClass.classLoader.getResource("file1.java").toURI()).toString()
        generator.generate(file)
    }
}