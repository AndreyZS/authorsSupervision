<!--<template>-->
<!--  <div>-->
<!--    <div class="title">-->
<!--      <h1>Авторизация</h1>-->
<!--    </div>-->
<!--    <div class="container">-->
<!--      <div class="left"></div>-->
<!--      <div class="right">-->
<!--        <div class="formBox">-->
<!--          <div>-->
<!--            <p>Логин</p>-->
<!--            <input :value="login" @input="event => login = event.target.value" type="text" name="" placeholder="Login">-->
<!--            <p>Пароль</p>-->
<!--            <input :value="password" @input="event => password = event.target.value" type="password" name="" placeholder="****">-->
<!--            <button  @click="this.test">Войти</button>-->
<!--            <a href="#">Регистрация</a>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<template>
  <section>
    <div  class="container" :class="{active: isReg}">
      <div class="user signinBx">
        <div class="imgBx"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Rusty_lock_in_Dijon.jpg/800px-Rusty_lock_in_Dijon.jpg"></div>
        <div class="formBx">
          <div>
            <h2>Авторизация</h2>
            <input type="text" placeholder="Логин">
            <input type="password" placeholder="****">
            <button>Войти</button>
            <p class="signup">У вас нет аккаунта? <a href="#" @click="this.toggleForm()">Создать</a></p>
          </div>
        </div>
      </div>
      <div class="user signupBx">
        <div class="formBx">
          <div>
            <h2>Регистрация</h2>
            <input type="text" placeholder="Логин">
            <input type="text" placeholder="Фамилия">
            <input type="text" placeholder="Имя">
            <input type="text" placeholder="Отчество">
            <input type="text" placeholder="Отдел">
            <input type="password" placeholder="****">
            <button>Создать</button>
            <p class="signup">У вас есть аккаунта? <a href="#" @click="this.toggleForm()">Войти</a></p>
          </div>
        </div>
        <div class="imgBx"><img src="https://ratatum.com/wp-content/uploads/2016/11/11-9.jpg"></div>

      </div>
    </div>
  </section>
</template>
<script>

export default {
  name: "Login",
  data(){
    return {
      isReg: false
    }

  },
  computed:{

  },
  props: {
    login: "",
    password: ""
  },
  methods: {
    test() {
      this.$store.dispatch('AuthModule/onLogin', {
        login: this.login,
        password: this.password
      })
      alert(this.login + " " + this.password)
    },
    toggleForm(){
      this.isReg = !this.isReg
    }
  }

}
</script>

<style scoped>

section {
  position: relative;
  min-height: 100vh;
  background: #557085;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.5s;
}

section .container {
  position: relative;
  width: 800px;
  height: 500px;
  background: #fff;
  box-shadow: 0 15px 50px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

section .container .user {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
}
section .container .user .imgBx{
  position: relative;
  width: 50%;
  height: 100%;
  transition: 0.5s;
}

section .container .user .imgBx img{
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

section .container .user .formBx{
  position: relative;
  width: 50%;
  height: 100%;
  background: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px;
  transition: 0.5s;
}

section .container .user .formBx h2{
  font-size: 18px;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 2px;
  text-align: center;
  width: 100%;
  margin-bottom: 10px;
  color: #555;
}

section .container .user .formBx input{
  width: 100%;
  padding: 10px;
  background: #f5f5f5;
  color: #333;
  border: none;
  outline: none;
  box-shadow: none;
  font-size: 14px;
  margin: 8px 0;
  letter-spacing: 1px;
  font-weight: 300;
}
section .container .user .formBx button{
  max-width: 100px;
  background: #677eff;
  color: #fff;
  cursor: pointer;
  font-size: 14px;
  letter-spacing: 1px;
  font-weight: 500;
  transition: 0.5s;
}

section .container .user.signupBx .formBx button{
  max-width: 100px;
  background: #e73e49;
  color: #fff;
  cursor: pointer;
  font-size: 14px;
  letter-spacing: 1px;
  font-weight: 500;
  transition: 0.5s;
}

section .container .signupBx{
  pointer-events: none;
}
section .container.active .signupBx{
  pointer-events: initial;
}
section .container .signupBx .formBx{
  top: 100%;
}

section .container.active .signupBx .formBx{
  top: 0;
}

section .container .signupBx .imgBx{
  top: -100%;
  transition: 0.5s;
}

section .container.active .signupBx .imgBx{
  top: 0;
}

section .container .user .formBx .signup{
  position: relative;
  margin-top: 20px;
  font-size: 12px;
  letter-spacing: 1px;
  color: #555;
  text-transform: uppercase;
  font-weight: 300;
}

section .container .user .formBx .signup a{
  font-weight: 600;
  text-decoration: none;
  color: #677eff;

}


section .container .signinBx .formBx{
  top: 0;
}

section .container.active .signinBx .formBx{
  top: 100%;
}


section .container .signinBx .imgBx{
  top: 0;
  transition: 0.5s;
}

section .container.active .signinBx .imgBx{
  top: -100%;
}

</style>