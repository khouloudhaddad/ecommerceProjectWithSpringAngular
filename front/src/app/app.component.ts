import {Component, OnInit} from '@angular/core';
import {UserStorageService} from "./services/storage/user-storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'EcommerceApp';

  isGuestLoggedIn: boolean = UserStorageService.isGuestLoggedIn();
  isAdminLoggedIn: boolean = UserStorageService.isAdminLoggedIn();

  constructor(private router: Router) {
  }

  ngOnInit(): void {
     this.router.events.subscribe(event=>{
      this.isGuestLoggedIn = UserStorageService.isGuestLoggedIn();
      this.isAdminLoggedIn = UserStorageService.isAdminLoggedIn();
     })
  }

  logOut(): void {
    UserStorageService.signOut();
    this.router.navigateByUrl('login');
  }


}
