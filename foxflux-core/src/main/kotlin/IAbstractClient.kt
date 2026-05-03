
interface IAbstractClient {
    fun ping(id: Int): Any?
    fun send(id: Int, data: Any)
    fun changeState(newState: ClientStates)
}