fun isEven() {
    (1..5).forEach {
        println(it)
        if (it % 2 == 0) return
    }
    println("done")
}
