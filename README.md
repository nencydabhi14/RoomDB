# Room Data Base 


Here is the Code Of RoomDatabase

-> Here is Model Class But Do not create Dataclass.

-> Model Class(Student)


Student.kt

    import androidx.room.ColumnInfo
    import androidx.room.Entity
    import androidx.room.PrimaryKey

    @Entity(tableName = "student")
    class Student {
    
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "name")
    var name = ""

    @ColumnInfo(name = "email")
    var email = ""

    @ColumnInfo(name = "phone")
    var phone = ""


    constructor(id:Int,name:String,email:String,phone:String) {
        this.id = id
        this.name = name
        this.email = email
        this.phone = phone
         }
    }   



Dao.kt


    import androidx.room.Dao
    import androidx.room.Delete
    import androidx.room.Insert
    import androidx.room.Query

    @Dao
    interface Dao {

    @Insert
    fun insertData(std : Student)

    @Delete
    fun deleteData(std: Student)

    @Query("SELECT * From student")
    fun readData() : List<Student>

    }
    
RoomDB is the combine of Student class and Dao Class.

RoomDB.kt    

    import android.content.Context
    import androidx.room.Database
    import androidx.room.Room
    import androidx.room.RoomDatabase


    @Database(entities = [Student::class], version = 1)
    abstract class RoomDB : RoomDatabase() {

    abstract fun studentDao(): Dao

    companion object {

        fun createRoomDB(context: Context): RoomDB {

            return Room.databaseBuilder(context.applicationContext, RoomDB::class.java, "MyDB")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build()
          }

       }

    }



MainActivity.kt

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import com.example.roomdb.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        var roomDB = RoomDB.createRoomDB(this)

        mainBinding.txt.setOnClickListener {

            var std1 = Student(0,"Android","abc@gmail.com","1234567891")
            roomDB.studentDao().insertData(std1)
            }
        }
    }


