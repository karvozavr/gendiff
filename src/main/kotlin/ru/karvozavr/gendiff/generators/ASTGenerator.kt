package ru.karvozavr.gendiff.generators

import com.github.gumtreediff.client.Run
import com.github.gumtreediff.gen.Generators
import com.github.gumtreediff.gen.jdt.JdtTreeGenerator
import com.github.gumtreediff.io.TreeIoUtils

class ASTGenerator {

    fun generate(file: String): String {
        Run.initGenerators()
        val generator = "java-jdt"
        val treeContext = Generators.getInstance().getTree(generator, file)
        return TreeIoUtils.toText(treeContext).toString()
    }
}