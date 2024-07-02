import com.presbtrack.models.enums.Role
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
        @Id var id: Long,
        var name: String,
        var bornDate: String,
        var cpf: String,
        var phoneNumber: String,
        var role: Role
)