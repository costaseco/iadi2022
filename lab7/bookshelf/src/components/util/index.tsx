export const Navigation = (props: { menuItems: string[] }) =>
    <div>
        {props.menuItems.join(" | ")}
    </div>

export const Login = ({ user }: { user?: string }) => {

    const logout = <div>Hello {user} <button>Logout</button></div>
    const login = <div>username: <input type="text" />
        password: <input type="text" />
        <button>Sign in</button>
    </div>

    return user ? logout : login
}
