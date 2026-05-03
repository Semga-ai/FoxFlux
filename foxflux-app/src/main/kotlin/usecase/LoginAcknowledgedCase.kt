package usecase

import IAbstractClient

class LoginAcknowledgedCase {
    fun trg(client: IAbstractClient) {
        client.changeState(ClientStates.CONFIGURATION)
        client.send(0, false)
    }
}