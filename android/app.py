from kivymd.app import MDApp
from kivy.lang import Builder

class ConfyApp(MDApp):
    def build(self):
        self.theme_cls.theme_style = "Dark"
        return Builder.load_file("android/screens.kv")
