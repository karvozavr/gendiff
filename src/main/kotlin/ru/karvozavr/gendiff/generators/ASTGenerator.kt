package ru.karvozavr.gendiff.generators

import com.github.gumtreediff.client.Run
import com.github.gumtreediff.gen.Generators
import com.github.gumtreediff.io.TreeIoUtils

class ASTGenerator {

    fun generate(file: String): String {
        Run.initGenerators()
        val treeContext = Generators.getInstance().getTree(file)
        return TreeIoUtils.toText(treeContext).toString()
    }
}