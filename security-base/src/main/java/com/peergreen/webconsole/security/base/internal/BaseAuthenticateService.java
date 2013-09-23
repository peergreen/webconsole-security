/**
 * Peergreen S.A.S. All rights reserved.
 * Proprietary and confidential.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.peergreen.webconsole.security.base.internal;

import javax.security.auth.Subject;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;

import com.peergreen.security.UsernamePasswordAuthenticateService;
import com.peergreen.webconsole.security.AuthenticateService;

/**
 * @author Mohammed Boukada
 */
@Component
@Instantiate
@Provides
public class BaseAuthenticateService implements AuthenticateService {

    @Requires
    private UsernamePasswordAuthenticateService delegateAuthenticateService;

    @Override
    public Subject authenticate(String username, String password) {
        return delegateAuthenticateService.authenticate(username, password);
    }
}
