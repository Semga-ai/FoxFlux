package usecase
import IAbstractClient
import dto.LoginData
import java.util.UUID

class LoginCase {
    fun trg(client: IAbstractClient,name: String, uuid: UUID) {
        System.out.println("$name - $uuid")
        client.send(2, LoginData(name, uuid, 0, true))
    }
}