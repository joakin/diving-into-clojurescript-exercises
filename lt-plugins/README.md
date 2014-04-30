
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


### 2. Reagent mini-intro

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

    <div class=app>
      <h3 class=title>...
      <div class=plugins>
        Nothing here yet...

*Code is in `src-steps/2`*

### 3. Fetch data from the server

We could use cljs-ajax to fetch the list of plugins from our server,
since we are doing just the frontend, I faked something. Look at
`src-steps/3/ajax.cljs` and paste it in your project.

* Include our new namespace in `core`
* Call to `ajax/get-plugins` to see what is in there
* Print the first result to the console to see what we can show

*Code is in `src-steps/3`*

### 4. Printing the list of plugins

Print a list of the names of the plugins.

* Just pass the data to your root app component, and pass it down to its subcomponents
* Use `for` calling your new plugin component over the plugins list

Try to generate something like this:

    <div class=plugin>
      <h3><a href='url'>Plugin name</a></h3>
      <p class=version>0.0.0
      <p class=installs>12

*Code is in `src-steps/4`*

### 5. Detailed view of the plugin

We are going to add a button to the plugin component, and a detailed view of all the plugin data that will be shown when we click this "expand" button.

* Modify your plugin component to add the button:

    <div class=actions>
      <button class=expand>+</button>

* Add an on-click handler to the attributes map.
* Add state to the plugin: expanded (true|false).
  * You have to make your plugin function return a function (let [...] (fn [] ...)) as seen in the [Time component](https://github.com/holmsand/reagent#examples)
  * We encapsulate state in an atom, locally to the component `(atom false)`
  * We get the value of the atom with `(deref x)` or just `@x`
  * Change the + to a - depending on the state
* Make the click handler `swap` the atom value to transition state
* Create a new component, `plugin-details`. It gets plugin data and renders it all detailed. Call it from `plugin` when it is in its state expanded (at the end of the `.plugin` div)
  * Render this keys: `{:keys [added updated installs repo url user] {:keys [name version author source desc]} :info}`

Try to get the details with this structure:

    <div class="details">
      <p class="desc">Clojure integration for Light Table</p>
      <div class="label-value">
        <div class="label">By</div>
        <div class="value">Kodowa</div>
      </div>
      <div class="label-value">
        <div class="label">Updated</div>
        <div class="value">Thu Apr 17 2014</div>
      </div>
      <div class="label-value">
        <div class="label">Added</div>
        <div class="value">Wed Jan 08 2014</div>
      </div>
      <div class="label-value">
        <div class="label">Url</div>
        <div class="value">
          <a href="https://github.com/LightTable/Clojure">https://github.com/LightTable/Clojure</a>
        </div>
      </div>
    </div>

*Code is in `src-steps/5`*

### 6. Organize the code

Let's move each part of the code to its own namespace separated logically.

Get the code to look like this:

    src/lt_plugins/
    ├── ajax.cljs
    ├── core.cljs
    ├── date.cljs
    └── ui
        ├── app.cljs
        ├── label_value.cljs
        └── plugins.cljs

*Code is in `src-steps/6`*


