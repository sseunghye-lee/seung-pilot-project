<template>
    <div class="sign">
        <div class="sign-in" style="text-align: center; align-items: center; align-content: center;">
            <div><img src="~@/assets/img/main_0duck.jpeg" alt="" class="logo" style="height: 450px" >
            </div>
            <div>
                <el-input  ref="loginEmail"
                          @keyup.enter="this.$refs.loginPw.focus()" size="large"
                          placeholder="아이디를 입력하세요." maxlength="40" @keypress="noSpace($event)"
                          class="sign-input/v/sign/out"/>
            </div>
            <div>
                <el-input ref="loginPw"
                          @keyup.enter="this.onclickLogin" size="large" show-password
                          type="password" maxlength="16" @keypress="noSpace($event)" placeholder="비밀번호를 입력하세요." class="sign-input"/>
            </div>
            <div class="sign-in-text">
                <el-checkbox label="로그인 상태 유지"
                             size="small"></el-checkbox>
            </div>
        </div>
    </div>

</template>

<!--<script src="./SIGN_IN.js">-->
<!--</script>-->

<style lang="scss" scoped>

</style>
