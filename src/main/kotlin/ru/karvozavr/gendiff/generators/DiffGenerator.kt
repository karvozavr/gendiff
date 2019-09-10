package ru.karvozavr.gendiff.generators

import com.github.gumtreediff.actions.ChawatheScriptGenerator
import com.github.gumtreediff.actions.Diff
import com.github.gumtreediff.actions.EditScript
import com.github.gumtreediff.client.Run
import com.github.gumtreediff.client.diff.web.WebDiff
import com.github.gumtreediff.gen.Generators
import com.github.gumtreediff.matchers.MappingStore
import com.github.gumtreediff.matchers.Matchers

class DiffGenerator {

    fun generateDiff(source: String, destination: String): EditScript {
        Run.initGenerators()

        val src = Generators.getInstance().getTree(source)
        val dst = Generators.getInstance().getTree(destination)

        val mappings: MappingStore = Matchers.getInstance().matcher.match(src.root, dst.root)
        return ChawatheScriptGenerator().computeActions(mappings)
    }

    fun showHTMLDiff(source: String, destination: String) {
        WebDiff(arrayOf(source, destination)).run()
    }
}