import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";
import {AuthService} from "../services/auth/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  registerForm!: FormGroup;
  hidePassword= true;

  constructor(private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]]
    });
  }

  togglePasswordVisibility(): void {
    this.hidePassword = !this.hidePassword;
  }

  onSubmit(): void {
    const password = this.registerForm.get('password')?.value;
    const confirmPassword = this.registerForm.get('confirmPassword')?.value;

    if(password !== confirmPassword){
      this.snackBar.open("Passwords do not match.", 'Close', { duration: 5000, panelClass: 'error-snackbar'});
      return;
    }

    this.authService.register(this.registerForm.value).subscribe(
    (response) => {
      this.snackBar.open("User successfully registered.", 'Close', { duration: 5000 });
      this.router.navigateByUrl("/login");
    },
    (error) => {
      this.snackBar.open("Sign up failed. Please try again later", 'Close', { duration: 5000, panelClass: 'error-snackbar'});
    }
    )
  }

}
