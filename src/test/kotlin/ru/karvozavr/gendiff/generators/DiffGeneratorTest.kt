package ru.karvozavr.gendiff.generators

import org.junit.Test

import org.junit.Before
import java.nio.file.Paths

class DiffGeneratorTest {

    private lateinit var diffGenerator: DiffGenerator

    @Before
    fun init() {
        diffGenerator = DiffGenerator()
    }

    @Test
    fun generateDiff() {
        val src = Paths.get(javaClass.classLoader.getResource("file1.java").toURI()).toString()
        val dst = Paths.get(javaClass.classLoader.getResource("file2.java").toURI()).toString()
        val diff = diffGenerator.generateDiff(src, dst)
        diff.forEach { println(it) }
    }
}