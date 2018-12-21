import java.util.*

fun<T, C: MutableCollection<T>> Collection<T>.partitionTo(collection1: Collection<T>, collection2: Collection<T>, predicate: Collection<T>.(T) -> Boolean): Pair<Collection<T>, Collection<T>>{
    val partitioned = this.partition { this.predicate(it) }

}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
