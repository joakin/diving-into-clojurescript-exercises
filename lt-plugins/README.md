
Lighttable plugin list
======================

A small webapp for the **diving into clojurescript** workshop.

We are going to build a small webapp to visualize the lighttable plugins on a list.

```
lein cljsbuild auto
```

Open lighttable and a browser tab, and connect to it to eval and play with the
code.

The different versions of the code are stored in `src-steps/`.

Library references:
https://github.com/holmsand/reagent
https://github.com/JulianBirch/cljs-ajax#getpost-examples


Steps
-----

### 1. Initial project

Look for project.clj. Compilation setup and dependencies.

**Web ouput is in `web/`**

`web/index.html` and a `web/style.css`

**Source is in src**
`src/lt_plugins/core.cljs`

**For live development:**

* In a terminal: `lein cljsbuild auto`
* In Lighttable:
  * ctrl-space -> Add browser tab
  * Put the full url of your index.html as in Chrome
    `file:///Users/jkn/dev/projects/diving-into-clojurescript/code/exercises/lt-plugins/web/index.html`
  * Go to `core.cljs`
  * cmd-enter on the `println`
  * When LT asks, choose the file url
  * Connected to a browser!!
  * Open the console (View -> Console) and see the println do its thing (shares browser tab console with LT console)


2. Reagent mini-intro

Reagent is a cljs->react interface. Components are just functions that return data structures or other functions.

Let's try this example:

```
(def app-dom (.querySelector js/document "#app"))

(defn app []
  [:div.app
   [:h1.title "hi!"]
   [some-component "OHAI!"]])

(defn some-component [sufix]
  [:div
   [:h3 "I am a component! " sufix]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"]
    " text."]])

(reagent/render-component [app]
                          app-dom)
```

Then, render a title and a placeholder for where we will list our plugins

*Code is in `src-steps/2`*
