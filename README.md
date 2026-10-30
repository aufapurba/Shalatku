Sealed interface lebih baik daripada tiga boolean isLoading, isError, dan isSuccess 
karena hanya mengizinkan satu keadaan pada satu waktu, sedangkan tiga boolean memungkinkan 
kombinasi yang mustahil, misalnya loading dan error sekaligus. 
Dengan when tanpa else, kompiler memaksa kita menangani semua keadaan, 
sehingga menambah keadaan baru tanpa menanganinya akan gagal dikompilasi. 
Selain itu, tiap keadaan membawa datanya sendiri (daftar waktu untuk Success, pesan untuk Error), 
jadi tidak ada data yang tertinggal atau tidak sinkron.