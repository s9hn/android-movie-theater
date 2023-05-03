package woowacourse.movie.model

object ReservationTicketMachine {
    private val _tickets = mutableListOf<MovieTicketModel>()
    val tickets: List<MovieTicketModel>
        get() = _tickets.toList().sortedBy { it.time }

    fun add(ticketModel: MovieTicketModel) {
        _tickets.add(ticketModel)
    }
}
