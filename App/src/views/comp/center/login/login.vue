<style lang="less">
  @import "./login";
</style>
<style type="text/css">
  @import "./vendor/bootstrap/css/bootstrap.min.css";
  @import "fonts/font-awesome-4.7.0/css/font-awesome.min.css";
  @import "fonts/iconic/css/material-design-iconic-font.min.css";
  @import "./vendor/animate/animate.css";
  @import "./vendor/css-hamburgers/hamburgers.min.css";
  @import "./vendor/animsition/css/animsition.min.css";
  @import "./vendor/select2/select2.min.css";
  @import "./vendor/daterangepicker/daterangepicker.css";
  @import "./css/util.css";
  @import "./css/main.css";

</style>
<template>
      <div id="login_D" class="box">
        <div class="limiter">
          <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
              <form class="login100-form validate-form">
					<span class="login100-form-title p-b-49">
						Login
					</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                  <span class="label-input100">Username</span>
                  <input class="input100" type="text" name="username" placeholder="Type your username">
                  <!--<span class="focus-input100" data-symbol="&#xf206;"></span>-->
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                  <span class="label-input100">Password</span>
                  <input class="input100" type="password" name="pass" placeholder="Type your password">
                  <!--<span class="focus-input100" data-symbol="&#xf190;"></span>-->
                </div>

                <div class="text-right p-t-8 p-b-31">
                  <a href="#">
                    Forgot password?
                  </a>
                </div>

                <div class="container-login100-form-btn">
                  <div class="wrap-login100-form-btn">
                    <div class="login100-form-bgbtn"></div>
                    <button class="login100-form-btn">
                      Login
                    </button>
                  </div>
                </div>

                <div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Or Sign Up Using
						</span>
                </div>

                <div class="flex-c-m">
                  <a href="#" class="login100-social-item bg1">
                    <i class="fa fa-facebook"></i>
                  </a>

                  <a href="#" class="login100-social-item bg2">
                    <i class="fa fa-twitter"></i>
                  </a>

                  <a href="#" class="login100-social-item bg3">
                    <i class="fa fa-google"></i>
                  </a>
                </div>

                <div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17">
							Or Sign Up Using
						</span>

                  <a href="#" class="txt2">
                    Sign Up
                  </a>
                </div>
              </form>
            </div>
          </div>
        </div>


        <div id="dropDownSelect1"></div>
      </div>
</template>
<!--===============================================================================================-->
<script src="./vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/bootstrap/js/popper.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/daterangepicker/moment.min.js"></script>
<script src="./vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="./vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>
<script>
    // import $ from 'jquery'
    export default {
        name: "login"
    }
</script>

<style scoped>

</style>
