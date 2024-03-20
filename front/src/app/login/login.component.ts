import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AuthService} from "../services/auth/auth.service";
import {Router} from "@angular/router";
import {UserStorageService} from "../services/storage/user-storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm!: FormGroup;
  hidePassword= true;

  constructor(private fb: FormBuilder,
              private snackBar: MatSnackBar,
              private authService: AuthService,
              private router: Router
  ) {
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
    });
  }

  togglePasswordVisibility(): void {
    this.hidePassword = !this.hidePassword;
  }

  onSubmit(): void {
    const username = this.loginForm.get('email')!.value;
    const password = this.loginForm.get('password')!.value;

    this.authService.login(username, password).subscribe(
        (res: any) => {
          this.snackBar.open("User successfully logged in.", 'Ok', { duration: 5000 });
          if(UserStorageService.isAdminLoggedIn()){
            this.router.navigateByUrl('admin/dashboard');
          }else if(UserStorageService.isGuestLoggedIn()){
            this.router.navigateByUrl('guest/dashboard');
          }
        },
        (error: any) => {
          this.snackBar.open("Bad credentials", 'ERROR', { duration: 5000})
        }
    )
  }
}
